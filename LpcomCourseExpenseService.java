package com.sai.lendperfect.application.courseexpense;

import java.util.List;

import com.sai.lendperfect.application.model.LpcustAppcustRelation;
import com.sai.lendperfect.application.model.LpcustApplicantEduCourseExp;
import com.sai.lendperfect.commodel.LpcomPropDocument;
import com.sai.lendperfect.commodel.LpcomProposal;

public interface LpcomCourseExpenseService {
	List<LpcustApplicantEduCourseExp> findByLpcomProposal(LpcomProposal lpcomProposal);
    List<LpcustApplicantEduCourseExp> save(List<LpcustApplicantEduCourseExp> lpcustApplicantEduCourseExpList);
	List<LpcustApplicantEduCourseExp>findAllByLpcomProposal(LpcomProposal lpcomProposal);

} 
