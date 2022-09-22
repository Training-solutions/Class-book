/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.eschool.openapi.v1.api;

import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.ErrorView;
import com.eschool.openapi.v1.model.PageViewDto;
import com.eschool.openapi.v1.model.SubjectDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-04T11:27:54.497233400+03:00[Asia/Istanbul]")
@Validated
@Api(value = "SubjectsV1", description = "the SubjectsV1 API")
public interface SubjectsV1Api {

    /**
     * DELETE /ui/subjects/{subjectId} : Subject deleting
     *
     * @param subjectId Id for subject deleting (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Subject deleting", nickname = "deleteSubject", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "subjects-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @DeleteMapping(
        value = "/ui/subjects/{subjectId}",
        produces = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> deleteSubject(@ApiParam(value = "Id for subject deleting",required=true) @PathVariable("subjectId") Long subjectId);


    /**
     * GET /ui/subjects/{subjectId} : Information about concrete subject
     *
     * @param subjectId Subject identifier (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Information about concrete subject", nickname = "getSubjectById", notes = "", response = SubjectDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "subjects-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = SubjectDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @GetMapping(
        value = "/ui/subjects/{subjectId}",
        produces = { "application/json" }
    )
    ResponseEntity<SubjectDto> getSubjectById(@ApiParam(value = "Subject identifier",required=true) @PathVariable("subjectId") Long subjectId);


    /**
     * GET /ui/subjects : List of subjects
     *
     * @param page Page number (optional)
     * @param size Subjects count on page (optional)
     * @param sort Sort criteria (can have multiple declarations - id, subjectTitle) (optional, default to new ArrayList&lt;&gt;())
     * @param id Filter by id (optional, default to new ArrayList&lt;&gt;())
     * @param subjectTitle Filter by subjectTitle (optional, default to new ArrayList&lt;&gt;())
     * @param creationDate Filter by creationDate (optional)
     * @param changingDate Filter by changingDate (optional)
     * @param isDeleted Filter by isDeleted (optional)
     * @return Successful response (status code 200)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "List of subjects", nickname = "getSubjectList", notes = "", response = PageViewDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "subjects-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = PageViewDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @GetMapping(
        value = "/ui/subjects",
        produces = { "application/json" }
    )
    ResponseEntity<PageViewDto<SubjectDto>> getSubjectList(Pageable pageable);


    /**
     * POST /ui/subjects : Creating new subject
     *
     * @param subjectDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Creating new subject", nickname = "postSubject", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "subjects-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @PostMapping(
        value = "/ui/subjects",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> postSubject(@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) SubjectDto subjectDto);


    /**
     * PUT /ui/subjects/{subjectId} : Subject updating
     *
     * @param subjectId Id for subject updating (required)
     * @param subjectDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Subject updating", nickname = "updateSubject", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "subjects-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @PutMapping(
        value = "/ui/subjects/{subjectId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> updateSubject(@ApiParam(value = "Id for subject updating",required=true) @PathVariable("subjectId") Long subjectId,@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) SubjectDto subjectDto);

}
