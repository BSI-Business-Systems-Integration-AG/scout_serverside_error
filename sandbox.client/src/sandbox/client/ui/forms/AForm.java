/**
 *
 */
package sandbox.client.ui.forms;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.service.SERVICES;

import sandbox.client.ui.forms.AForm.MainBox.CancelButton;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox.Child1Box;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox.Child2Box;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox.Child3Box;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox.FirstNameField;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox.LastNameField;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox.PersonIdField;
import sandbox.client.ui.forms.AForm.MainBox.ContentBox.StartDateField;
import sandbox.client.ui.forms.AForm.MainBox.Load1Button;
import sandbox.client.ui.forms.AForm.MainBox.Load2Button;
import sandbox.client.ui.forms.AForm.MainBox.Load3Button;
import sandbox.client.ui.forms.AForm.MainBox.OkButton;
import sandbox.client.ui.forms.field.AbstractSdbxDateField;
import sandbox.client.ui.forms.field.AbstractSdbxLongField;
import sandbox.client.ui.forms.field.AbstractSdbxStringField;
import sandbox.client.ui.template.form.AbstractSdbxForm;
import sandbox.client.ui.template.formfield.AbstractChildGroupBox;
import sandbox.shared.AFormData;
import sandbox.shared.IAService;

/**
 * @author jbr
 */
@FormData(value = AFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class AForm extends AbstractSdbxForm {

  private Long m_testNr;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public AForm() throws ProcessingException {
    super();
  }

  /**
   * @return the TestNr
   */
  @FormData
  public Long getTestNr() {
    return m_testNr;
  }

  /**
   * @param testNr
   *          the TestNr to set
   */
  @FormData
  public void setTestNr(Long testNr) {
    m_testNr = testNr;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Test");
  }

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public void startNew() throws ProcessingException {
    startInternal(new NewHandler());
  }

  /**
   * @return the PersonIdField
   */
  public PersonIdField getPersonIdField() {
    return getFieldByClass(PersonIdField.class);
  }

  /**
   * @return the StartDateField
   */
  public StartDateField getStartDateField() {
    return getFieldByClass(StartDateField.class);
  }

  /**
   * @return the CancelButton
   */
  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  /**
   * @return the Child1Box
   */
  public Child1Box getChild1Box() {
    return getFieldByClass(Child1Box.class);
  }

  /**
   * @return the Child2Box
   */
  public Child2Box getChild2Box() {
    return getFieldByClass(Child2Box.class);
  }

  /**
   * @return the Child3Box
   */
  public Child3Box getChild3Box() {
    return getFieldByClass(Child3Box.class);
  }

  /**
   * @return the ContentBox
   */
  public ContentBox getContentBox() {
    return getFieldByClass(ContentBox.class);
  }

  /**
   * @return the FirstNameField
   */
  public FirstNameField getFirstNameField() {
    return getFieldByClass(FirstNameField.class);
  }

  /**
   * @return the LastNameField
   */
  public LastNameField getLastNameField() {
    return getFieldByClass(LastNameField.class);
  }

  /**
   * @return the Load1Button
   */
  public Load1Button getLoad1Button() {
    return getFieldByClass(Load1Button.class);
  }

  /**
   * @return the Load2Button
   */
  public Load2Button getLoad2Button() {
    return getFieldByClass(Load2Button.class);
  }

  /**
   * @return the Load3Button
   */
  public Load3Button getLoad3Button() {
    return getFieldByClass(Load3Button.class);
  }

  /**
   * @return the MainBox
   */
  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  /**
   * @return the OkButton
   */
  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class ContentBox extends AbstractGroupBox {

      @Order(10.0)
      public class FirstNameField extends AbstractSdbxStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FirstName");
        }
      }

      @Order(20.0)
      public class LastNameField extends AbstractSdbxStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LastName");
        }
      }

      @Order(30.0)
      public class PersonIdField extends AbstractSdbxLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("PersonId");
        }

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }
      }

      @Order(40.0)
      public class StartDateField extends AbstractSdbxDateField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("StartDate");
        }
      }

      @Order(50.0)
      public class Child1Box extends AbstractChildGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Child1");
        }

      }

      @Order(60.0)
      public class Child2Box extends AbstractChildGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Child2");
        }
      }

      @Order(70.0)
      public class Child3Box extends AbstractChildGroupBox {

        @Override
        protected boolean getConfiguredExpanded() {
          return false;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Child3");
        }
      }
    }

    @Order(20.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(30.0)
    public class CancelButton extends AbstractCancelButton {
    }

    @Order(40.0)
    public class Load1Button extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Load1");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        IAService service = SERVICES.getService(IAService.class);
        AFormData formData = new AFormData();
        exportFormData(formData);
        formData = service.load(1);
        importFormData(formData);
      }
    }

    @Order(50.0)
    public class Load2Button extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Load2");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        IAService service = SERVICES.getService(IAService.class);
        AFormData formData = new AFormData();
        exportFormData(formData);
        formData = service.load(2);
        importFormData(formData);
      }
    }

    @Order(60.0)
    public class Load3Button extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Load3");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        IAService service = SERVICES.getService(IAService.class);
        AFormData formData = new AFormData();
        exportFormData(formData);
        formData = service.load(3);
        importFormData(formData);
      }
    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IAService service = SERVICES.getService(IAService.class);
      AFormData formData = new AFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);
    }

    @Override
    protected void execStore() throws ProcessingException {
      IAService service = SERVICES.getService(IAService.class);
      AFormData formData = new AFormData();
      exportFormData(formData);
      formData = service.create(formData);
    }
  }
}
