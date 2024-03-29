package com.eschool.classbook.student;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.StudentDto;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

@Sql(scripts = {"classpath:sql/data.sql"})
public class StudentResourceIntegrationTest extends BaseIntegrationTest {
    @LocalServerPort
    int port;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void givenStudent_whenSave_thenStudentSavedSuccessfully() {
        StudentDto studentDto = TestData.getStudentDto();
        CredentialDto credentialDto = TestData.getCredentialDto();
        studentDto.setCredential(credentialDto);

        given()
                .port(port)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(studentDto)
                .when()
                .post("/ui/students")
                .then()
                .statusCode(200)
                .body("responseId", equalTo(4))
                .body("status", equalTo("Student with id - 4 saved successfully"));
    }

    @Test
    public void givenStudent_whenFindById_thenStudentFoundSuccessfully() {
        given()
                .port(port)
                .when()
                .get("/ui/students/{id}", 1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("firstName", equalTo("Steven"))
                .body("lastName", equalTo("Venson"))
                .body("creationDate", notNullValue())
                .body("modifyingDate", notNullValue())
                .body("deleted", equalTo(false))
                .body("credential.id", equalTo(1))
                .body("credential.username", equalTo("steven_venson"))
                .body("credential.password", equalTo("uwjwwwefwko"))
                .body("credential.creationDate", notNullValue())
                .body("credential.modifyingDate", notNullValue())
                .body("credential.deleted", equalTo(false))
                .body("group.id", equalTo(1))
                .body("group.groupTitle", equalTo("2A"))
                .body("group.deleted", equalTo(false))
                .body("teachers", notNullValue())
                .body("teachers.id", hasItems(1))
                .body("teachers.firstName", hasItems("David"))
                .body("teachers.lastName", hasItems("Hekston"))
                .body("teachers.creationDate", hasItems(notNullValue()))
                .body("teachers.modifyingDate", hasItems(notNullValue()))
                .body("teachers.deleted", hasItems(false))
                .body("teachers.credential", hasItems(nullValue()))
                .body("teachers.groups", hasItems(nullValue()))
                .body("teachers.students", hasItems(nullValue()))
                .body("teachers.subjects", hasItems(nullValue()))
                .body("subjects", notNullValue())
                .body("subjects.id", hasItems(1))
                .body("subjects.subjectTitle", hasItems("MATH"))
                .body("subjects.creationDate", hasItems(notNullValue()))
                .body("subjects.modifyingDate", hasItems(notNullValue()))
                .body("subjects.deleted", hasItems(false))
                .body("subjects.groups", hasItems(nullValue()))
                .body("subjects.students", hasItems(nullValue()))
                .body("subjects.teachers", hasItems(nullValue()))
                .body("subjects.scores", notNullValue())
                .body("subjects.scores.id", hasItems(hasItems(1)))
                .body("subjects.scores.score", hasItems(hasItems(11)))
                .body("subjects.creationDate", hasItems(notNullValue()))
                .body("subjects.modifyingDate", hasItems(notNullValue()))
                .body("subjects.deleted", hasItems(false));
    }

    @Test
    public void givenStudent_whenFindById_thenExceptionThrows() {
        given()
                .port(port)
                .when()
                .get("/ui/students/{id}", 10)
                .then()
                .statusCode(500)
                .body("timestamp", notNullValue())
                .body("status", equalTo(500))
                .body("errorCode", nullValue())
                .body("message", equalTo("Student with id 10 was not found"))
                .body("path", nullValue());
    }

    @Test
    @Order(1)
    public void givenStudentList_whenFindAll_thenFoundStudentListSuccessfully() {
        given()
                .port(port)
                .when()
                .get("/ui/students?page={page}&size={size}", 0,10)
                .then()
                .statusCode(200)
                .body("total", equalTo(3))
                .body("data", notNullValue());
    }

    @Test
    public void givenStudent_whenUpdate_thenStudentUpdatedSuccessfully() {
        StudentEntity student = studentRepository.getById(1L);
        StudentDto studentDto = studentMapper.toDto(student);
        studentDto.setFirstName("Henry");

        given()
                .port(port)
                .when()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(studentDto)
                .put("/ui/students/{id}", 1)
                .then()
                .statusCode(200)
                .body("responseId", equalTo(1))
                .body("status", equalTo("Student with id - 1 updated successfully"));
    }

    @Test
    public void givenStudent_whenDelete_thenStudentDeletedSuccessfully() {
        given()
                .port(port)
                .when()
                .delete("/ui/students/{id}", 3)
                .then()
                .statusCode(200)
                .body("responseId", equalTo(3))
                .body("status", equalTo("Student with id - 3 deleted successfully"));
    }
}
