/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.eschool.openapi.v1.api;

import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.ErrorDto;
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
@Api(value = "StudentV1", description = "the StudentV1 API")
public interface StudentV1Api {

    /**
     * DELETE /ui/students/{studentId} : Student deleting
     *
     * @param studentId Id for student updating (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Student deleting", nickname = "deleteStudent", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "student-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @DeleteMapping(
        value = "/ui/students/{studentId}",
        produces = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _deleteStudent(@ApiParam(value = "Id for student updating",required=true) @PathVariable("studentId") Long studentId);

}