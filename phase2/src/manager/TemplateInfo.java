package manager;

import java.io.Serializable;

public class TemplateInfo implements Serializable {

    private String templateInfo;

    public String getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(String newInfo){
        templateInfo = newInfo;
    }
}
