/**
 *
 */
package sandbox.client.ui.forms.field;

import org.eclipse.scout.commons.exception.IProcessingStatus;
import org.eclipse.scout.rt.client.ui.form.fields.AbstractFormField;
import org.eclipse.scout.rt.client.ui.form.fields.AbstractValueField;
import org.eclipse.scout.rt.client.ui.form.fields.IFormField;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractFormFieldData;

import sandbox.shared.services.field.AbstractValueFieldDataWithStatus;

/**
 * @author jbr
 */
public class SdbxFieldUtility {

  /**
   * Intercepter for {@link AbstractFormField#importFormFieldData(AbstractFormFieldData, boolean)} for the
   * {@link IValueFieldWithStatus}
   *
   * @param field
   * @param source
   */
  static void importFormFieldData(IValueFieldWithStatus field, AbstractFormFieldData source) {
    if (source instanceof AbstractValueFieldDataWithStatus) {
      field.execImportFieldStatus(((AbstractValueFieldDataWithStatus) source).getStatus());
    }
    else {
      throw new IllegalStateException("formFieldData should be from type AbstractValueFieldDataWithStatus in a IValueFieldWithStatus.");
    }
  }

  /**
   * Default implementation for {@link IValueFieldWithStatus#execImportFieldStatus(IProcessingStatus)}
   *
   * @param field
   * @param status
   */
  public static void importFieldStatus(IFormField field, IProcessingStatus status) {
    if (status != null) {
      field.setErrorStatus(new ServerFieldStatus(status));
    }
  }

  /**
   * Intercepter for {@link AbstractValueField#validateValueInternal}.
   * Clear the server error status.
   *
   * @param field
   */
  static void clearFieldStatus(IFormField field) {
    if (field.getErrorStatus() instanceof ServerFieldStatus) {
      field.clearErrorStatus();
    }
  }
}
