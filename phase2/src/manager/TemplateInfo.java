package manager;

import java.io.Serializable;

/**
 * A class that manages template info.
 */
public class TemplateInfo implements Serializable {

    /**
     * String containing info for the template
     */
    private String templateInfo;

    /**
     * @return the info for the template.
     */
    public String getTemplateInfo() {
        return templateInfo;
    }

    /**
     * Set the new info for the template.
     * @param newInfo the new info to set the template to
     */
    public void setTemplateInfo(String newInfo){
        templateInfo = newInfo;
    }
}
