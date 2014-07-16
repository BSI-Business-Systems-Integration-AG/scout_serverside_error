/**
 * 
 */
package sandbox.shared;

import java.security.BasicPermission;

/**
 * @author jbr
 */
public class ReadAPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  /**
 * 
 */
  public ReadAPermission() {
    super("ReadA");
  }
}
