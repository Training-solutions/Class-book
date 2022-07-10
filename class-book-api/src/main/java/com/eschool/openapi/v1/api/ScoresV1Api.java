/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.eschool.openapi.v1.api;

import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.ErrorDto;
import com.eschool.openapi.v1.model.ScoreDto;
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
@Api(value = "ScoresV1", description = "the ScoresV1 API")
public interface ScoresV1Api {

    /**
     * DELETE /ui/scores/{scoreId} : Score deleting
     *
     * @param scoreId Id for score deleting (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Score deleting", nickname = "deleteScore", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "scores-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @DeleteMapping(
        value = "/ui/scores/{scoreId}",
        produces = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _deleteScore(@ApiParam(value = "Id for score deleting",required=true) @PathVariable("scoreId") Long scoreId);


    /**
     * GET /ui/scores/{scoreId} : Information about concrete score
     *
     * @param scoreId Score identifier (required)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Information about concrete score", nickname = "getScoreById", notes = "", response = ScoreDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "scores-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ScoreDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @GetMapping(
        value = "/ui/scores/{scoreId}",
        produces = { "application/json" }
    )
    ResponseEntity<ScoreDto> _getScoreById(@ApiParam(value = "Score identifier",required=true) @PathVariable("scoreId") Long scoreId);


    /**
     * POST /ui/scores : Creating new score
     *
     * @param scoreDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Creating new score", nickname = "postScore", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "scores-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @PostMapping(
        value = "/ui/scores",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _postScore(@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) ScoreDto scoreDto);


    /**
     * PUT /ui/scores/{scoreId} : Score updating
     *
     * @param scoreId Id for score updating (required)
     * @param scoreDto Callback payload (optional)
     * @return Successful response (status code 200)
     *         or Supplied request data are invalid (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or User is not granted sufficient privileges (status code 403)
     *         or Resource was not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @ApiOperation(value = "Score updating", nickname = "updateScore", notes = "", response = CommonResponseDto.class, authorizations = {
        
        @Authorization(value = "bearerAuth")
         }, tags={ "scores-v1", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = CommonResponseDto.class),
        @ApiResponse(code = 400, message = "Supplied request data are invalid", response = ErrorDto.class),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 403, message = "User is not granted sufficient privileges", response = ErrorDto.class),
        @ApiResponse(code = 404, message = "Resource was not found", response = ErrorDto.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    @PutMapping(
        value = "/ui/scores/{scoreId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommonResponseDto> _updateScore(@ApiParam(value = "Id for score updating",required=true) @PathVariable("scoreId") Long scoreId,@ApiParam(value = "Callback payload"  )  @Valid @RequestBody(required = false) ScoreDto scoreDto);

}
