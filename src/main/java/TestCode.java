import net.htmlparser.jericho.Renderer;
import net.htmlparser.jericho.Source;

/*import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;*/
import java.io.Serializable;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCode {


    public static final String XML_TAGS_REGEX = "\\<[^>]*>";

    public static String getPlainContentFromHtmlContent(String htmlContent) {
        String plainContent = "";
        try {
            if (!htmlContent.isEmpty()) {
                Source source = new Source(htmlContent);
                Renderer renderer = source.getRenderer();
                if (renderer != null) {
                    plainContent = renderer.toString().replaceAll(XML_TAGS_REGEX, "").trim();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error while getting plain content from html content: ");
        }
        return plainContent;
    }

    public static void main(String[] args) {

        Campaign camp = new Campaign();
        camp.setName("camp");
        System.out.println(camp);
        if(camp.getCampaignID().isEmpty()) {
            System.out.println("yes it is empty");
        }

    }
}
