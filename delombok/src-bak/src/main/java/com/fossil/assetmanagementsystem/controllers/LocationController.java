package com.fossil.assetmanagementsystem.controllers;

import com.fossil.assetmanagementsystem.dtos.LocationDto;
import com.fossil.assetmanagementsystem.projections.LocationView;
import com.fossil.assetmanagementsystem.services.LocationService;
import com.fossil.assetmanagementsystem.util.Response;
import com.fossil.assetmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/location")
public class LocationController {
    @Autowired
    private final LocationService locationService;

    private final ResponseBuild<LocationDto> locationDtoResponseBuild;

    private final ResponseBuild<LocationView> locationViewResponseBuild;

    private final ResponseBuild<Boolean> locationDeleteResponseBuild;

    @GetMapping("/findAllLocations")
    public ResponseEntity<Response> findAllLocations(){
        return new ResponseEntity<>(locationViewResponseBuild.listResponseFunction.
                apply(locationService.findAllLocations()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getSingleLocation(@PathVariable Integer id){
        return new ResponseEntity<>(locationDtoResponseBuild.responseFunction.
                apply(locationService.findById(id)), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createLocation(@RequestBody LocationDto locationDto){
        return new ResponseEntity<>(locationDtoResponseBuild.responseFunction.
                apply(locationService.save(locationDto)), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateLocation(@PathVariable("id") Integer id,@RequestBody LocationDto locationDto){
        return new ResponseEntity<>(locationDtoResponseBuild.responseFunction.
                apply(locationService.update(id,locationDto)), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteLocation(@PathVariable("id") Integer id){
        return new ResponseEntity<>(locationDeleteResponseBuild.responseFunction.
                apply(locationService.deleteById(id)), HttpStatus.OK);
    }

}
