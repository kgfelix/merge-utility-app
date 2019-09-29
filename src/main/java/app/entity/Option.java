package app.entity;

/**
 * Class representing an entity System option. An Option is a parameter sent
 * after a command that indicates functionality such: as the destination file,
 * source file, etc. Usually an option is presented by a "-" followed by a
 * letter. An option may be followed by one or more arguments. As an option "-s"
 * representing destination files you can have a list of these files.
 *
 * @author Kleber Felix
 * @version 1.0
 * @since 2019-09-27
 */
public class Option {

    /** Letter indicating an option. */
    private String key;
    /** Represents a list of parameters sent to the option. */
    private String params = "";

    /**
     * Default constructor. 
     * Initializes the object with the key attribute
     */
    public Option(String _key) {
        this.key = _key;
    }

    // **************************************************
    // Métodos GET e SET
    // **************************************************
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getParams() {
        return params.trim();
    }

    public void setParams(String params) {
        this.params = params;
    }

    /** Add a new parameter */
    public void addParam(String param) {
        params = params.concat(param).concat(" ");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Option other = (Option) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Option [key=" + key + ", params=" + params + "]";
    }
}