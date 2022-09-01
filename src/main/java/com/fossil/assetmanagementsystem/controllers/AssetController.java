package com.fossil.assetmanagementsystem.controllers;

import com.fossil.assetmanagementsystem.dtos.AssetDto;
import com.fossil.assetmanagementsystem.entities.Asset;
import com.fossil.assetmanagementsystem.projections.AssetView;
import com.fossil.assetmanagementsystem.services.AssetService;
import com.fossil.assetmanagementsystem.util.Response;
import com.fossil.assetmanagementsystem.util.ResponseBuild;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/asset")
public class AssetController {
    private final AssetService assetService;

    private final ResponseBuild<AssetDto> assetDtoResponseBuild;

    private final ResponseBuild<AssetView> assetViewResponseBuild;

    private final ResponseBuild<Boolean> assetDeleteResponseBuild;

    @GetMapping("/")
    public ResponseEntity<Response>  findAllAssets(){
        return new ResponseEntity<>(assetViewResponseBuild.listResponseFunction.
                apply(assetService.findAllAssets()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getSingleAsset(@PathVariable Integer id){
        return new ResponseEntity<>(assetDtoResponseBuild.responseFunction.
                apply(assetService.findById(id)), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createAsset(@RequestBody AssetDto assetDto){
        return new ResponseEntity<>(assetDtoResponseBuild.responseFunction.
                apply(assetService.save(assetDto)), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateAsset(@PathVariable("id") Integer id,@RequestBody AssetDto assetDto){
        return new ResponseEntity<>(assetDtoResponseBuild.responseFunction.
                apply(assetService.update(id,assetDto)), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteAsset(@PathVariable("id") Integer id){
        return new ResponseEntity<>(assetDeleteResponseBuild.responseFunction.
                apply(assetService.deleteById(id)), HttpStatus.OK);
    }






}
