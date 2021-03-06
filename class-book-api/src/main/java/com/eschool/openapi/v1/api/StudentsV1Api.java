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
import com.eschool.openapi.v1.model.StudentDto;
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
@Api(value = "StudentsV1", description = "the StudentsV1 API")
public interface StudentsV1Api {

    /**
     * GET /ui/students/{studentId} : Information about concrete student
     *
     * @param studentId Student identifier (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Information about concrete student", nickname = "getStudentById", notes = "", response = StudentDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "students-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = StudentDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @GetMapping(
        value = "/ui/students/{studentId}",
        produces = { "application/json" }
    )
    ResponseEntity<StudentDto> _getStudentById(@ApiParam(value = "Student identifier",required=true) @PathVariable("studentId") Long studentId);


    /**
     * GET /ui/students : List of students
     *
     * @param page Page number (optional)
     * @param size Students count on page (optional)
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
    @ApiOperation(value = "List of students", nickname = "getStudentList", notes = "", response = PageViewDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "students-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = PageViewDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @GetMapping(
        value = "/ui/students",
        produces = { "application/json" }
    )
    ResponseEntity<PageViewDto> _getStudentList(@ApiParam(value = "Page number") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Students count on page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sort criteria (can have multiple declarations - id, firstName, lastName, creationDate, changingDate, isDeleted)") @Valid @RequestParam(value = "sort", required = false) List<String> sort,@ApiParam(value = "Filter by id") @Valid @RequestParam(value = "id", required = false) List<Long> id,@ApiParam(value = "Filter by firstName") @Valid @RequestParam(value = "firstName", required = false) List<String> firstName,@ApiParam(value = "Filter by lastName") @Valid @RequestParam(value = "lastName", required = false) List<String> lastName,@ApiParam(value = "Filter by creationDate") @Valid @RequestParam(value = "creationDate", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) OffsetDateTime creationDate,@ApiParam(value = "Filter by changingDate") @Valid @RequestParam(value = "changingDate", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) OffsetDateTime changingDate,@ApiParam(value = "Filter by isDeleted") @Valid @RequestParam(value = "isDeleted", required = false) Boolean isDeleted);


    /**
     * POST /ui/students : Creating new student
     *
     * @param studentDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Creating new student", nickname = "postStudent", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "students-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @PostMapping(
        value = "/ui/students",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _postStudent(@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) StudentDto studentDto);


    /**
     * PUT /ui/students/{studentId} : Student updating
     *
     * @param studentId Id for student updating (required)
     * @param studentDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Student updating", nickname = "updateStudent", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "students-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @PutMapping(
        value = "/ui/students/{studentId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _updateStudent(@ApiParam(value = "Id for student updating",required=true) @PathVariable("studentId") Long studentId,@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) StudentDto studentDto);

}
