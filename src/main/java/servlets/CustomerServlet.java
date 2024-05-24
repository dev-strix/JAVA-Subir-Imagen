package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;



//@WebServlet("/CustomerServlet") //Esto se puede configurar en el (WEB-INF/web.xml)  o tambien como interface(@WebServlet("/NombreServlet"))
@MultipartConfig
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //esto deberia tener una variable para seleccionar la ruta de donde se pegaran los archivos, de momento lo dejamos asi.
    private String pathFiles = "C:\\Users\\deyvi\\OneDrive\\Documentos\\NetBeansProjects\\UploadImageJava\\src\\main\\resources\\files\\";
    private File uploads = new File(pathFiles);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "add":
                //esto solo envia con el boton name=add, no guarda
                saveCustomer(request, response);
                break;

            default:
                break;
        }

    }

    private void saveCustomer(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Part part = req.getPart("file");

            if (part == null) {
                System.out.println("No ha seleccionado un archivo");
                return;
            }

            if (isExtension(part.getSubmittedFileName(), extens)) {
                String photo = saveFile(part, uploads);
                System.out.println("(CustomerServlet.java)La Ruta origen del copiado es: "+photo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //ESto solamente redirecciona
        res.sendRedirect("index.jsp");
    }

    private String saveFile(Part part, File pathUploads) {
        String pathAbsolute = "";

        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            System.out.println("Nombre del Archivo: "+fileName);
            InputStream input = part.getInputStream();

            if (input != null) {
                File file = new File(pathUploads, fileName);
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathAbsolute;
    }

    private boolean isExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }
        return false;
    }
}
