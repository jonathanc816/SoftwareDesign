/**
 * This the class of templates for different targets
 * i.e. Message
 *
 * @author  Yupeng Chang
 * @version 1.0
 * @since   2020-07-09
 */

public class Template {
    private final String name;
    private final String target;
    private final int paraNum;
    private String info;
    private String[] instructions;

    /**
     * The constructor of Template
     * @param name This is the unique name of a template
     * @param target i.e. massage, reminder, etc. This indicates what object this template will generate
     * @param paraNum The number of arguments needs to fill the template
     * @param info The introduction of the template
     * @param instructions Series of instructions, one for each parameter
     */
    public Template(String name, String target, int paraNum, String info, String[] instructions) {
        this.name = name;
        this.target = target;
        this.paraNum = paraNum;
        this.info = info;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getTarget() {
        return target;
    }

    public int getParaNum() {
        return paraNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }
}
