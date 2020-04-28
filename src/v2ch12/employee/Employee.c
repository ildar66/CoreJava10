/**
   @version 1.10 1999-11-13
   @author Cay Horstmann
*/

#include "v2ch12.employee.Employee.h"

#include <stdio.h>

JNIEXPORT void JNICALL Java_v2ch12_employee_Employee_raiseSalary(JNIEnv* env, jobject this_obj, jdouble byPercent)
{  
   /* get the class */
   jclass class_Employee = (*env)->GetObjectClass(env, this_obj);

   /* get the field ID */
   jfieldID id_salary = (*env)->GetFieldID(env, class_Employee, "salary", "D");

   /* get the field value */
   jdouble salary = (*env)->GetDoubleField(env, this_obj, id_salary);

   salary *= 1 + byPercent / 100;

   /* set the field value */
   (*env)->SetDoubleField(env, this_obj, id_salary, salary);
}

