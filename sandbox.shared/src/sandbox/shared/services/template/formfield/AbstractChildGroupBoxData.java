/**
 * 
 */
package sandbox.shared.services.template.formfield;

import java.util.Map;

import javax.annotation.Generated;

import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractFormFieldData;

import sandbox.shared.services.field.AbstractValueFieldDataWithStatus;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 * 
 * @generated
 */
@Generated(value = "org.eclipse.scout.sdk.workspace.dto.formdata.FormDataDtoUpdateOperation", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public abstract class AbstractChildGroupBoxData extends AbstractFormFieldData {

  private static final long serialVersionUID = 1L;

  public AbstractChildGroupBoxData() {
  }

  public Age getAge() {
    return getFieldByClass(Age.class);
  }

  public Name getName() {
    return getFieldByClass(Name.class);
  }

  public static class Age extends AbstractValueFieldDataWithStatus<Integer> {

    private static final long serialVersionUID = 1L;

    public Age() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_VALUE, Integer.MAX_VALUE);
      ruleMap.put(ValidationRule.MIN_VALUE, Integer.MIN_VALUE);
    }
  }

  public static class Name extends AbstractValueFieldDataWithStatus<String> {

    private static final long serialVersionUID = 1L;

    public Name() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }
}
