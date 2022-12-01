package com.eschool.classbook.group;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.openapi.v1.model.GroupDto;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Sql(scripts = {"classpath:sql/data.sql"})
public class GroupResourceIntegrationTests extends BaseIntegrationTest {
    @LocalServerPort
    int port;

    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void givenResource_whenSave_thenGroupSavedSuccessfully(){
        GroupDto groupDto = TestData.getGroupDto();

        given()
                .port(port)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(groupDto)
                .then()
                .statusCode(200)
                .body("responseId", equalTo(5))
                .body("status", equalTo("Group with id - 5 saved successfully"));
    }

    @Test
    public void givenGroup_whenFindById_thenGroupFoundSuccessfully(){
        given()
                .port(port)
                .when()
                .get("/ui/groups/{id}", 1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("group_title", equalTo("2A"))
                .body("creation_date", notNullValue())
                .body("deleted", equalTo(false))
                .body("modifying_date", notNullValue())
                .body("deleted", equalTo(false))
                .body("students", notNullValue())
                .body("students.first_name", hasItems("Steven"))
                .body("students.last_name", hasItems("Venson"))
                .body("students.id", hasItems(1))
                .body("students.credential", hasItems(nullValue()))
                .body("students.creationDate", hasItems(nullValue()))
                .body("students.modifyingDate", hasItems(nullValue()))
                .body("students.deleted", hasItems(false))
                .body("students.teachers", hasItems(nullValue()))
                .body("students.subjects", hasItems(nullValue()))
                .body("students.group", hasItems(nullValue()))
                .body("teachers", hasItems(notNullValue()))
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
                .body("subjects.scores.score", hasItems(hasItems(10)))
                .body("subjects.creationDate", hasItems(notNullValue()))
                .body("subjects.modifyingDate", hasItems(notNullValue()))
                .body("subjects.deleted", hasItems(false));

    }

    @Test
    public void givenGroup_whenFindById_thenExceptionThrows(){
        given()
                .port(port)
                .when()
                .get("/ui/groups/{id}", 10)
                .then()
                .statusCode(500)
                .body("timestamp", notNullValue())
                .body("status", equalTo(500))
                .body("errorCode", nullValue())
                .body("message", equalTo("Group with id 10 was not found"))
                .body("path", nullValue());
    }

    @Test
    @Order(1)
    public void givenGroupList_whenFindAll_thenFoundGroupListSuccessfully(){
        given()
                .port(port)
                .when()
                .get("/ui/groups?page={page}&size={size}", 0,10)
                .then()
                .statusCode(200)
                .body("total", equalTo(4))
                .body("data", notNullValue());
    }

    @Test
    public void givenGroup_whenUpdate_thenGroupUpdatedSuccessfully(){
        GroupEntity groupEntity = groupRepository.getById(1L);
        GroupDto groupDto = groupMapper.toDto(groupEntity);
        groupDto.setGroupTitle("4А");

        given()
                .port(port)
                .when()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(groupDto)
                .put("/ui/groups/{id}", 1)
                .then()
                .statusCode(200)
                .body("responseId", equalTo(1))
                .body("status", equalTo("Group with id - 1 updated successfully"));
    }
    @Test
    public void givenGroup_whenDelete_thenGroupDeletedSuccessfully(){
        given()
                .port(port)
                .when()
                .delete("/ui/groups/{id}", 3)
                .then()
                .statusCode(200)
                .body("responseId", equalTo(3))
                .body("status", equalTo("Student with id - 3 deleted successfully"));
    }

}
