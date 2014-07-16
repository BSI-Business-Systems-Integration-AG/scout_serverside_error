/**
 *
 */
package sandbox.client.ui.forms.field;

import org.eclipse.scout.commons.exception.IProcessingStatus;

/**
 * @author jbr
 */
public interface IValueFieldWithStatus {

  /**
   * @param status
   */
  void execImportFieldStatus(IProcessingStatus status);

}
