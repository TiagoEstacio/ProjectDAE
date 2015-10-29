/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejbs.AdministratorBean;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;


@ManagedBean
@SessionScoped
public class AdministratorManager { 
    
    public AdministratorManager() {
    }
    /*
    @EJB
    private StudentBean studentBean;
    @EJB
    private CourseBean courseBean;
    @EJB
    private SubjectBean subjectBean;
    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private TeacherBean teacherBean;
    
    //students
    private String usernameM;
    private String passwordM;
    private String nameM;
    private String emailM;

    //courses
    private String courseIdM;
    private String courseNameM;
    
    //subjects
    private int subjectCodeM;
    private String subjectNameM;
    private Course subjectCourseM;
    private int subjectCourseYearM;
    private int subjectScholarYearM;
    
    //comuns
    private List<Student> students;
    private Student currentStudent;
    private String studentCourseId;
    private List<Course> courses;
    private Course currentCourse;
    private List<Subject> subjects;

    public int getSubjectCodeM() {
        return subjectCodeM;
    }

    public void setSubjectCodeM(int subjectCodeM) {
        this.subjectCodeM = subjectCodeM;
    }

    public String getSubjectNameM() {
        return subjectNameM;
    }

    public void setSubjectNameM(String subjectNameM) {
        this.subjectNameM = subjectNameM;
    }

    public Course getSubjectCourseM() {
        return subjectCourseM;
    }

    public void setSubjectCourseM(Course subjectCourseM) {
        this.subjectCourseM = subjectCourseM;
    }

    public int getSubjectCourseYearM() {
        return subjectCourseYearM;
    }

    public void setSubjectCourseYearM(int subjectCourseYearM) {
        this.subjectCourseYearM = subjectCourseYearM;
    }

    public int getSubjectScholarYearM() {
        return subjectScholarYearM;
    }

    public void setSubjectScholarYearM(int subjectScholarYearM) {
        this.subjectScholarYearM = subjectScholarYearM;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getCourseIdM() {
        return courseIdM;
    }

    public void setCourseIdM(String courseIdM) {
        this.courseIdM = courseIdM;
    }

    public String getCourseNameM() {
        return courseNameM;
    }

    public void setCourseNameM(String courseNameM) {
        this.courseNameM = courseNameM;
    }

    public String getUsernameM() {
        return usernameM;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public void setUsernameM(String usernameM) {
        this.usernameM = usernameM;
    }

    public String getPasswordM() {
        return passwordM;
    }

    public void setPasswordM(String passwordM) {
        this.passwordM = passwordM;
    }

    public String getNameM() {
        return nameM;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    public String getEmailM() {
        return emailM;
    }

    public void setEmailM(String emailM) {
        this.emailM = emailM;
    }

     public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public String getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(String studentCourseId) {
        this.studentCourseId = studentCourseId;
    }
    
    public String createStudent(){
        try {
            studentBean.createStudent(usernameM, passwordM, nameM, emailM, studentCourseId);
            //String a = "index?faces-redirect=true";
            //return a;
            clearNewStudent();
            return (String) "index?faces-redirect=true";
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
            //System.out.println("ERROR - STUDENT NOT INSERTED!!!");
        }  
    }

    public List<Student> getAllStudents(){
        try {
            this.students = studentBean.getAll();
            return students; 
            
            //outra solução - sem declarar a List<Student> nas variáveis
            // return (List<Student>) studentBean.getAll();
      
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());       
        }
    }
    
    private void clearNewStudent() {
        usernameM = null;
        passwordM = null;
        nameM = null;
        emailM = null;
    }
 
    public String updateStudent(){
        try {
            studentBean.update(currentStudent.getUsername(), currentStudent.getPassword(), currentStudent.getName(), currentStudent.getEmail(), currentStudent.getCourse().getCourseId());
            return (String) "index?faces-redirect=true";
        } catch (NumberFormatException ex) {
            throw new EJBException(ex.getMessage()); 
        }
    }

    public void removeStudent(ActionEvent event){
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteStudentId");
            String id = param.getValue().toString();
            studentBean.remove(id);
        
        } catch (NumberFormatException ex) {
            throw new EJBException(ex.getMessage()); 
        }
    }

    
     public String createCourse(){
        try {
            courseBean.createCourse(courseIdM, courseNameM);
            clearNewCourse();
            return (String) "index?faces-redirect=true";
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }  
    }

    public List<Course> getAllCourses(){
        try {
            this.courses = courseBean.getAll();
            return courses;    
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());       
        }
    }
   
    private void clearNewCourse() {
        courseIdM = null;
        courseNameM = null;
    }
 
    public String updateCourse(){
        try {
            courseBean.update(currentCourse.getCourseId(), currentCourse.getCourseName());
            return (String) "index?faces-redirect=true";
        } catch (NumberFormatException ex) {
            throw new EJBException(ex.getMessage()); 
        }
    }

    public void removeCourse(ActionEvent event){
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteCourseId");
            String cId = param.getValue().toString();
            
            courseBean.remove(cId);
        
        } catch (NumberFormatException ex) {
            throw new EJBException(ex.getMessage()); 
        }
    }
  
    public List<Subject> getAllSubjectsStudents(Student currentStudent){
        try {
            this.subjects = studentBean.getAllSubjectsOfStudent(currentStudent);
            return subjects; 
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());       
        }
    } 
    */
   
}