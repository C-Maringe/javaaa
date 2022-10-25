package com.fossil.assetmanagementsystem.controllers;


import com.fossil.assetmanagementsystem.projections.AssetMovementLogsView;
import com.fossil.assetmanagementsystem.services.AssetMovementLogService;
import com.fossil.assetmanagementsystem.util.Response;
import com.fossil.assetmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/assetmovementlogs")
public class AssetMovementLogsController {
    private final AssetMovementLogService assetMovementLogService;
    private final ResponseBuild<AssetMovementLogsView> assetMovementLogsViewResponseBuild;

    @GetMapping("/")
    public ResponseEntity<Response> findAllAssetMovements(){
        return new ResponseEntity<>(assetMovementLogsViewResponseBuild.listResponseFunction.
                apply(assetMovementLogService.findAllAssetMovementsLogs()), HttpStatus.OK);
    }






}
