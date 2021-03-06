/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.eschool.openapi.v1.api;

import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.ErrorDto;
import java.time.OffsetDateTime;
import com.eschool.openapi.v1.model.PageViewDto;
import com.eschool.openapi.v1.model.TeacherDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-04T11:27:54.497233400+03:00[Asia/Istanbul]")
@Validated
@Api(value = "TeachersV1", description = "the TeachersV1 API")
public interface TeachersV1Api {

    /**
     * DELETE /ui/teachers/{teacherId} : Teacher deleting
     *
     * @param teacherId Id for teacher updating (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Teacher deleting", nickname = "deleteTeacher", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "teachers-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @DeleteMapping(
        value = "/ui/teachers/{teacherId}",
        produces = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _deleteTeacher(@ApiParam(value = "Id for teacher updating",required=true) @PathVariable("teacherId") Long teacherId);


    /**
     * GET /ui/teachers/{teacherId} : Information about concrete teacher
     *
     * @param teacherId Teacher identifier (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Information about concrete teacher", nickname = "getTeacherById", notes = "", response = TeacherDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "teachers-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = TeacherDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @GetMapping(
        value = "/ui/teachers/{teacherId}",
        produces = { "application/json" }
    )
    ResponseEntity<TeacherDto> _getTeacherById(@ApiParam(value = "Teacher identifier",required=true) @PathVariable("teacherId") Long teacherId);


    /**
     * GET /ui/teachers : List of teachers
     *
     * @param page Page number (optional)
     * @param size Teachers count on page (optional)
     * @param sort Sort criteria (can have multiple declarations - id, firstName, lastName, creationDate, changingDate, isDeleted) (optional, default to new ArrayList&lt;&gt;())
     * @param id Filter by id (optional, default to new ArrayList&lt;&gt;())
     * @param firstName Filter by firstName (optional, default to new ArrayList&lt;&gt;())
     * @param lastName Filter by lastName (optional, default to new ArrayList&lt;&gt;())
     * @param creationDate Filter by creationDate (optional)
     * @param changingDate Filter by changingDate (optional)
     * @param isDeleted Filter by isDeleted (optional)
     * @return Successful response (status code 200)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "List of teachers", nickname = "getTeacherList", notes = "", response = PageViewDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "teachers-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = PageViewDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @GetMapping(
        value = "/ui/teachers",
        produces = { "application/json" }
    )
    ResponseEntity<PageViewDto> _getTeacherList(@ApiParam(value = "Page number") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Teachers count on page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sort criteria (can have multiple declarations - id, firstName, lastName, creationDate, changingDate, isDeleted)") @Valid @RequestParam(value = "sort", required = false) List<String> sort,@ApiParam(value = "Filter by id") @Valid @RequestParam(value = "id", required = false) List<Long> id,@ApiParam(value = "Filter by firstName") @Valid @RequestParam(value = "firstName", required = false) List<String> firstName,@ApiParam(value = "Filter by lastName") @Valid @RequestParam(value = "lastName", required = false) List<String> lastName,@ApiParam(value = "Filter by creationDate") @Valid @RequestParam(value = "creationDate", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) OffsetDateTime creationDate,@ApiParam(value = "Filter by changingDate") @Valid @RequestParam(value = "changingDate", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) OffsetDateTime changingDate,@ApiParam(value = "Filter by isDeleted") @Valid @RequestParam(value = "isDeleted", required = false) Boolean isDeleted);


    /**
     * POST /ui/teachers : Creating new teacher
     *
     * @param teacherDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Creating new teacher", nickname = "postTeacher", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "teachers-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @PostMapping(
        value = "/ui/teachers",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _postTeacher(@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) TeacherDto teacherDto);


    /**
     * PUT /ui/teachers/{teacherId} : Teacher updating
     *
     * @param teacherId Id for teacher updating (required)
     * @param teacherDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Teacher updating", nickname = "updateTeacher", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "teachers-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @PutMapping(
        value = "/ui/teachers/{teacherId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _updateTeacher(@ApiParam(value = "Id for teacher updating",required=true) @PathVariable("teacherId") Long teacherId,@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) TeacherDto teacherDto);

}
