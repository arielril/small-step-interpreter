import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Environment
 */
public class Environment {
  private Map<String, Integer> mapping = new HashMap<>();

  /**
   * Add the variable with a value to the environment
   * 
   * @param variable Variable name
   * @param value    Variable value
   */
  public void add(String variable, int value) {
    mapping.put(variable, value);
  }

  /**
   * Updates the value of a variable
   * 
   * @param variable Variable name
   * @param value    Variable value
   */
  public void update(String variable, int value) {
    mapping.replace(variable, value);
  }

  /**
   * Gets the value of a variable
   * 
   * @param variable Variable name
   * @return The value of the requested variable
   */
  public int get(String variable) {
    return mapping.get(variable);
  }

  @Override
  public String toString() {
    StringBuilder env = new StringBuilder("[");
    Iterator<Entry<String, Integer>> iterator = mapping.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<String, Integer> e = iterator.next();
      env.append(e.getKey());
      env.append(" |-> ");
      env.append(e.getValue());
      if (iterator.hasNext()) 
        env.append(", ");
    }

    env.append("]");
    return env.toString();
  }
}