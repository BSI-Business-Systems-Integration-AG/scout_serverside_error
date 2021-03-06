/**
 *
 */
package sandbox.client.ui.forms.field;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.exception.IProcessingStatus;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractFormFieldData;

import sandbox.shared.services.field.AbstractValueFieldDataWithStatus;

/**
 * @author jbr
 */
@FormData(value = AbstractValueFieldDataWithStatus.class, sdkCommand = FormData.SdkCommand.USE, defaultSubtypeSdkCommand = FormData.DefaultSubtypeSdkCommand.CREATE)
public abstract class AbstractSdbxStringField extends AbstractStringField implements IValueFieldWithStatus {

  @Override
  public void importFormFieldData(AbstractFormFieldData source, boolean valueChangeTriggersEnabled) {
    super.importFormFieldData(source, valueChangeTriggersEnabled);
    SdbxFieldUtility.importFormFieldData(this, source);
  }

  @Override
  public void execImportFieldStatus(IProcessingStatus status) {
    SdbxFieldUtility.importFieldStatus(this, status);
  }

  @Override
  protected String validateValueInternal(String rawValue) throws ProcessingException {
    SdbxFieldUtility.clearFieldStatus(this);
    return super.validateValueInternal(rawValue);
  }
}
