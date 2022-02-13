package demos.iText7;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class PDFTest{

       public void pdf_7(){
              try {
                     String DEST = "c:\\tmp\\test7.pdf";
                     PdfFont font1 = PdfFontFactory.createFont("KozMinPro-Regular","UniJIS-UCS2-HW-H");
                     PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));

                  Document document = new Document(pdf);
                  String line = null;
                  Paragraph p = new Paragraph();
                  line = "For Japanese statement\n入庫日  数量  銘柄名 時価  通貨  代用価格";
                  p.add(new Text(line).setFont(font1));
                  line = "\n\nThis is English";
                  p.add(new Text(line));
                  document.add(p);
                  document.close();
              }catch (Exception e) {
                     e.printStackTrace();
              }
       }

       public static void main(String[] args) {
              PDFTest t = new PDFTest();
              t.pdf_7();
       }

}