/**
 *
 */
package sandbox.shared.services.field;

import org.eclipse.scout.commons.exception.IProcessingStatus;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

public abstract class AbstractValueFieldDataWithStatus<T> extends AbstractValueFieldData<T> {

  private static final long serialVersionUID = 1L;

  private IProcessingStatus status;

  public IProcessingStatus getStatus() {
    return status;
  }

  public void setStatus(IProcessingStatus status) {
    this.status = status;
  }
}
