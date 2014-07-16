/**
 *
 */
package sandbox.shared;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.validate.IValidationStrategy;
import org.eclipse.scout.rt.shared.validate.InputValidation;
import org.eclipse.scout.service.IService;

/**
 * @author jbr
 */
@InputValidation(IValidationStrategy.PROCESS.class)
public interface IAService extends IService {

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  AFormData create(AFormData formData) throws ProcessingException;

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  AFormData prepareCreate(AFormData formData) throws ProcessingException;

  /**
   * @param caseId
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  AFormData load(int caseId) throws ProcessingException;
}
