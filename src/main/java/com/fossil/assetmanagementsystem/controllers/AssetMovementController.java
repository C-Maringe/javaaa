package com.fossil.assetmanagementsystem.controllers;

import com.fossil.assetmanagementsystem.dtos.AssetMovementDto;
import com.fossil.assetmanagementsystem.enums.StatusEnum;
import com.fossil.assetmanagementsystem.projections.AssetMovementView;
import com.fossil.assetmanagementsystem.services.AssetMovementService;
import com.fossil.assetmanagementsystem.util.Response;
import com.fossil.assetmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/assetmovement")
public class AssetMovementController {

    private final AssetMovementService assetMovementService;

    private final ResponseBuild<AssetMovementDto> assetMovementDtoResponseBuild;

    private final ResponseBuild<AssetMovementView> assetMovementViewResponseBuild;

    private final ResponseBuild<Boolean> assetDeleteResponseBuild;

    @GetMapping("/")
    public ResponseEntity<Response> findAllAssetMovements(){
        return new ResponseEntity<>(assetMovementViewResponseBuild.listResponseFunction.
                apply(assetMovementService.findAllAssetMovements()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getSingleAssetMovement(@PathVariable Integer id){
        return new ResponseEntity<>(assetMovementDtoResponseBuild.responseFunction.
                apply(assetMovementService.findById(id)), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createAssetMovement(@RequestBody AssetMovementDto assetMovementDto){
        return new ResponseEntity<>(assetMovementDtoResponseBuild.responseFunction.
                apply(assetMovementService.save(assetMovementDto)), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateAssetMovement(@PathVariable("id") Integer id,@RequestBody AssetMovementDto assetMovementDto){
        return new ResponseEntity<>(assetMovementDtoResponseBuild.responseFunction.
                apply(assetMovementService.update(id,assetMovementDto)), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteAssetMovement(@PathVariable("id") Integer id){
        return new ResponseEntity<>(assetDeleteResponseBuild.responseFunction.
                apply(assetMovementService.deleteById(id)), HttpStatus.OK);
    }
    @GetMapping("/find-by-asset/{status}")
    public ResponseEntity<Response> findByAsset(@PathVariable("status") StatusEnum status){
        return new ResponseEntity<>(assetMovementViewResponseBuild.listResponseFunction.
                apply(assetMovementService.findAllByStatus(status)), HttpStatus.OK);
    }

}
