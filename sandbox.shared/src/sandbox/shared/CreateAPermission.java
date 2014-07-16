/**
 * 
 */
package sandbox.shared;

import java.security.BasicPermission;

/**
 * @author jbr
 */
public class CreateAPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  /**
 * 
 */
  public CreateAPermission() {
    super("CreateA");
  }
}
