package manager;

import entity.Template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This the class stores and modifies the template abjects
 *
 * @author  Yupeng Chang
 * @version 1.0
 * @since   2020-07-19
 */
public class TemplateManager implements Serializable {
    private List<Template> templates = new ArrayList<>();

    /**
     * The method return names of all templates as a list
     */
    public ArrayList<String> getAllNames() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Template template : templates) {
            nameList.add(template.getName());
        }
        return nameList;
    }

    /**
     * The method add one new template to the template list
     * @param template This is the new entity.Template object
     */
    public void addTemplate(Template template) {
        templates.add(template);
    }

    /**
     * The method add several new templates to the template list
     * @param newTemplates This is list of new entity.Template objects
     */
    public void addTemplate(List<Template> newTemplates) {
        templates.addAll(newTemplates);
    }

    /**
     * The getter method of a certain template
     * @param name This is the name of gotten object
     */
    public  Template getTemplate(String name) {
        for(Template template: templates) {
            if (template.getName().equals(name)) {
                return template;
            }
        }
        return null;
    }

    /**
     * The method modify the information of selected template
     * @param name This is the name of selected object
     * @param newInfo This is the new information
     */
    public void setTemplatesInfo(String name, String newInfo) {
        for (Template template : templates) {
            if (template.getName().equals(name)) {
                template.setInfo(newInfo);
            }
        }
    }
}
