/**
 *
 */
package sandbox.client.ui.forms.field;

import org.eclipse.scout.commons.exception.IProcessingStatus;
import org.eclipse.scout.rt.client.ui.form.fields.ScoutFieldStatus;

/**
 * @author jbr
 */
public class ServerFieldStatus extends ScoutFieldStatus {

  private static final long serialVersionUID = -398454270683780258L;

  /**
   * @param status
   */
  public ServerFieldStatus(IProcessingStatus status) {
    super(status, status.getSeverity());
  }
}
