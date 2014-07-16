/**
 *
 */
package sandbox.server;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.scout.commons.DateUtility;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.ProcessingStatus;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

import sandbox.shared.AFormData;
import sandbox.shared.CreateAPermission;
import sandbox.shared.IAService;

/**
 * @author jbr
 */
public class AService extends AbstractService implements IAService {

  @Override
  public AFormData create(AFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateAPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    return formData;
  }

  @Override
  public AFormData prepareCreate(AFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateAPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    return formData;
  }

  @Override
  public AFormData load(int caseId) throws ProcessingException {
    AFormData fd = new AFormData();

    switch (caseId) {
      case 1:
        fd.getFirstName().setValue("Billyy");
        fd.getFirstName().setStatus(new ProcessingStatus(TEXTS.get("WARN_CheckSpelling"), IStatus.WARNING));
        fd.getLastName().setValue("Evans");
        fd.getPersonId().setValue(4562L);
        fd.getStartDate().setValue(DateUtility.parse("2014-01-04", "yyyy-mm-dd"));
        fd.getChild1Box().getAge().setValue(5);
        fd.getChild1Box().getName().setValue("Brandon");
        fd.getChild2Box().getAge().setValue(5);
        fd.getChild2Box().getAge().setStatus(new ProcessingStatus(TEXTS.get("ERROR_SameAge"), IStatus.ERROR));
        fd.getChild2Box().getName().setValue("Ralph");
        fd.getChild3Box().getAge().setValue(null);
        fd.getChild3Box().getName().setValue(null);
        break;
      case 2:
        fd.getFirstName().setValue("Wanda");
        fd.getLastName().setValue("Clark");
        fd.getPersonId().setValue(156445L);
        fd.getPersonId().setStatus(new ProcessingStatus(TEXTS.get("WARN_IdOutdated"), IStatus.WARNING));
        fd.getStartDate().setValue(DateUtility.parse("2014-05-04", "yyyy-mm-dd"));
        fd.getChild1Box().getAge().setValue(3);
        fd.getChild1Box().getName().setValue("Doris");
        fd.getChild2Box().getAge().setValue(null);
        fd.getChild2Box().getName().setValue(null);
        fd.getChild3Box().getAge().setValue(null);
        fd.getChild3Box().getName().setValue(null);
        break;
      default:
        fd.getFirstName().setValue("Joe");
        fd.getLastName().setValue("Hughes");
        fd.getPersonId().setValue(7895L);
        fd.getStartDate().setValue(DateUtility.parse("2015-01-01", "yyyy-mm-dd"));
        fd.getStartDate().setStatus(new ProcessingStatus(TEXTS.get("WARN_DateInFuture"), IStatus.WARNING));
        fd.getChild1Box().getAge().setValue(null);
        fd.getChild1Box().getName().setValue(null);
        fd.getChild2Box().getAge().setValue(null);
        fd.getChild2Box().getName().setValue(null);
        fd.getChild3Box().getAge().setValue(null);
        fd.getChild3Box().getName().setValue(null);
        break;
    }

    return fd;
  }
}
