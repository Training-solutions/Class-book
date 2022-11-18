/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.eschool.openapi.v1.api;

import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.ErrorView;
import com.eschool.openapi.v1.model.PageViewDto;
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

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-04T11:27:54.497233400+03:00[Asia/Istanbul]")
@Validated
@Api(value = "CredentialsV1", description = "the CredentialsV1 API")
public interface CredentialsV1Api {

    /**
     * DELETE /ui/credentials/{credentialId} : Credential deleting
     *
     * @param credentialId Id for credential deleting (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(
        value = "Credential deleting",
        nickname = "deleteCredential",
        notes = "",
        response = CommonResponseDto.class,
        authorizations = {
            @Authorization(value = "bearerAuth")
         },
        tags={ "credentials-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @DeleteMapping(
        value = "/ui/credentials/{credentialId}",
        produces = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> deleteCredential(
        @ApiParam(value = "Id for credential deleting",required=true) @PathVariable("credentialId") Long credentialId
    );


    /**
     * GET /ui/credentials/{credentialId} : Information about concrete credential
     *
     * @param credentialId Credential identifier (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(
        value = "Information about concrete credential",
        nickname = "getCredentialById",
        notes = "",
        response = CredentialDto.class,
        authorizations = {
            @Authorization(value = "bearerAuth")
         },
        tags={ "credentials-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CredentialDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @GetMapping(
        value = "/ui/credentials/{credentialId}",
        produces = { "application/json" }
    )
    ResponseEntity<CredentialDto> getCredentialById(
        @ApiParam(value = "Credential identifier",required=true) @PathVariable("credentialId") Long credentialId
    );


    /**
     * GET /ui/credentials : List of credentials
     *
     * @param page Page number (optional)
     * @param size Credentials count on page (optional)
     * @param sort Sort criteria (can have multiple declarations - id, username, creationDate, changingDate, isDeleted) (optional, default to new ArrayList&lt;&gt;())
     * @param id Filter by id (optional, default to new ArrayList&lt;&gt;())
     * @param username Filter by username (optional, default to new ArrayList&lt;&gt;())
     * @param creationDate Filter by creationDate (optional)
     * @param changingDate Filter by changingDate (optional)
     * @param isDeleted Filter by isDeleted (optional)
     * @return Successful response (status code 200)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(
        value = "List of credentials",
        nickname = "getCredentialList",
        notes = "",
        response = PageViewDto.class,
        authorizations = {
            @Authorization(value = "bearerAuth")
         },
        tags={ "credentials-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = PageViewDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @GetMapping(
        value = "/ui/credentials",
        produces = { "application/json" }
    )
    ResponseEntity<PageViewDto<CredentialDto>> getCredentialList(Pageable pageable);


    /**
     * POST /ui/credentials : Creating new credential
     *
     * @param credentialDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(
        value = "Creating new credential",
        nickname = "postCredential",
        notes = "",
        response = CommonResponseDto.class,
        authorizations = {
            @Authorization(value = "bearerAuth")
         },
        tags={ "credentials-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @PostMapping(
        value = "/ui/credentials",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> postCredential(
        @ApiParam(value = "Callback payload") @Valid @RequestBody(required = false) CredentialDto credentialDto);


    /**
     * PUT /ui/credentials/{credentialId} : Credential updating
     *
     * @param credentialId Id for credential updating (required)
     * @param credentialDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(
        value = "Credential updating", nickname =
        "updateCredential",
        notes = "",
        response = CommonResponseDto.class,
        authorizations = {
            @Authorization(value = "bearerAuth")
         },
        tags={ "credentials-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorView.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorView.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorView.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorView.class) })
    @PutMapping(
        value = "/ui/credentials/{credentialId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> updateCredential(
        @ApiParam(value = "Id for credential updating",required=true) @PathVariable("credentialId") Long credentialId,
        @ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) CredentialDto credentialDto);
}
