/**
 *
 */
package sandbox.client.ui.template.formfield;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.shared.TEXTS;

import sandbox.client.ui.forms.field.AbstractSdbxIntegerField;
import sandbox.client.ui.forms.field.AbstractSdbxStringField;
import sandbox.shared.services.template.formfield.AbstractChildGroupBoxData;

/**
 * @author jbr
 */
@FormData(value = AbstractChildGroupBoxData.class, sdkCommand = FormData.SdkCommand.CREATE, defaultSubtypeSdkCommand = FormData.DefaultSubtypeSdkCommand.CREATE)
public abstract class AbstractChildGroupBox extends AbstractGroupBox {
  @Override
  protected boolean getConfiguredExpandable() {
    return true;
  }

  /**
   * @return the AgeField
   */
  public AgeField getAgeField() {
    return getFieldByClass(AgeField.class);
  }

  /**
   * @return the NameField
   */
  public NameField getNameField() {
    return getFieldByClass(NameField.class);
  }

  @Order(10.0)
  public class NameField extends AbstractSdbxStringField {

    @Override
    protected String getConfiguredLabel() {
      return TEXTS.get("Name");
    }
  }

  @Order(20.0)
  public class AgeField extends AbstractSdbxIntegerField {

    @Override
    protected String getConfiguredLabel() {
      return TEXTS.get("Age");
    }
  }

}
