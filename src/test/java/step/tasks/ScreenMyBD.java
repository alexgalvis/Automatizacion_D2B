package step.tasks;

import java.awt.image.BufferedImage;

import co.com.bancolombia.kioscos.automatizacion.modelos.BD.PantallaTextKio;
import co.com.bancolombia.kioscos.automatizacion.repository.otros.PantallasImpl;
import co.com.bancolombia.kioscos.automatizacion.repository.otros.Repositorio;
import net.serenitybdd.annotations.Step;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ScreenMyBD {

    private ArrayList<PantallaTextKio> screens;
    private final String tessdata = System.getProperty("user.dir") + "\\src\\resurces\\tessdata";

    public ScreenMyBD() {
        this.screens = new ArrayList<>();
    }

    @Step("proceso de cargar imagenes")
    public void load(String ruta,int idFlujo) throws IOException {
        int ban = 1;
        while (true){
            BufferedImage imagen = loadImage(ruta,ban);
            if (imagen == null){
                System.out.println("termino cargue de imagen....");break;}
            String text = ocr(imagen);
            text = filtrar(text.split("\n"));
            Long newId = guardarMyBD(new PantallaTextKio(text,0.9,idFlujo));
            renameImage(ruta,ban,newId,idFlujo);
            ban++;
        }
    }
    @Step("cargar imagen en ruta")
    public BufferedImage loadImage(String ruta,int id){
        try {
            return ImageIO.read(new File(ruta + id + ".png"));
        } catch (IOException e) {
            return null;
        }
    }
    @Step("renombrar imagen guardada en MyBD")
    public void renameImage(String ruta,int id, Long newId,int idFlujo) throws IOException{
        File oldFile = new File(ruta + id + ".png");
        File newFile = new File(ruta + newId + "_" + "flujo_" + idFlujo + ".png");
        boolean success = oldFile.renameTo(newFile);
        if (!success){
            throw new IOException("No se pudo renombrar imagen en local...");
        }
    }
    @Step("aplicar OCR")
    public String ocr(BufferedImage image){
        ITesseract tesseract = new Tesseract();
        tesseract.setTessVariable("user_defined_dpi","96");  // -> revisar si es necesario
        tesseract.setLanguage("spa");
        tesseract.setDatapath(tessdata);
        tesseract.setPageSegMode(4); // -> dependiendo el tipo de pantalla
        try {
            return tesseract.doOCR(image);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    @Step("filtrar")
    public  String filtrar(String[] array){
        StringBuilder textFilter = new StringBuilder();
        for (String line:array) {
            line = line.replaceAll("[^a-zA-Z0-9áéíóúñÁÉÍÓÚÑ,?!\t ]+", "");
            line = line.replace(" ","");
            if (line.length() >= 3) textFilter.append("\n").append(line);
        }
        return textFilter.toString();
    }
    @Step("guardar imagen en BD")
    public Long guardarMyBD(PantallaTextKio pantallaTextKio){
        Repositorio<PantallaTextKio> rep = new PantallasImpl();
        Long id = rep.insert(pantallaTextKio);
        pantallaTextKio.setId(id);
        screens.add(pantallaTextKio);
        return id;
    }
    @Step("consultar pantallas")
    public void checkScreen(Long idFlujo){
        Repositorio<PantallaTextKio> rep = new PantallasImpl();
        this.screens = rep.listarPorCategoria(idFlujo);
    }
    @Step("imprimir pantallas")
    public void printScreen(){
        for (PantallaTextKio pan:screens) {
            System.out.println(pan.toString());
        }
    }
    @Step("modificar pantalla")
    public void updateScreen(PantallaTextKio pantallaTextKio){
        Repositorio<PantallaTextKio> rep = new PantallasImpl();
        rep.Update(pantallaTextKio);
        screens.add(pantallaTextKio);
    }
    @Step("eliminar pantalla por id")
    public void deleteScreen(Long id){
        Repositorio<PantallaTextKio> rep = new PantallasImpl();
        rep.eliminar(id);
    }

}
