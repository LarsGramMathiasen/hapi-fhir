package ca.uhn.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.profiling.fhir.MyEpisodeOfCareFHIR;
import ca.uhn.fhir.profiling.fhir.common._MyReferralInformationComponent;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Reference;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class NullPointerExceptionTest {

	@Test
	public void testNullPointerException() {
		Bundle bundle = new Bundle();
		MyEpisodeOfCareFHIR myEpisodeOfCare = new MyEpisodeOfCareFHIR();
		_MyReferralInformationComponent myReferralInformation = new _MyReferralInformationComponent();
		myReferralInformation._setReferralType(new Coding("someSystem", "someCode", "someDisplay"));
		myReferralInformation._setFreeChoice(new Coding("someSystem2", "someCode", "someDisplay2"));
		myReferralInformation._setReceived(new DateTimeType(createDate(2017, Calendar.JULY, 31)));
		myReferralInformation._setReferringOrganisation(new Reference().setReference("someReference").setDisplay("someDisplay3"));
		myEpisodeOfCare._setReferralInformation(myReferralInformation);
		bundle.addEntry().setResource(myEpisodeOfCare);
		FhirContext ctx = FhirContext.forDstu3();
		ctx.newXmlParser().encodeResourceToString(bundle);
	}

	private static Date createDate(
		int year,
		int month,
		int day) {
		Calendar CAL = Calendar.getInstance();
		CAL.clear();
		CAL.set(year, month, day);
		return CAL.getTime();
	}
}
