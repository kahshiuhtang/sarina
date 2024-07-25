package com.krtopi.backend.mission.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/validates")
public class ValidateController {

    @Autowired
    private ValidateService validateService;

    @GetMapping
    public List<ValidateEntity> getAllValidates() {
        return validateService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidateEntity> getValidateById(@PathVariable Long id) {
        return validateService.findById(id)
                .map(validateEntity -> new ResponseEntity<>(validateEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ValidateEntity createValidate(@RequestBody ValidateEntity validateEntity) {
        return validateService.save(validateEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValidateEntity> updateValidate(@PathVariable Long id, @RequestBody ValidateEntity validateEntity) {
        return validateService.findById(id)
                .map(existingValidate -> {
                    existingValidate.setParentPostId(validateEntity.getParentPostId());
                    existingValidate.setIsPositive(validateEntity.getIsPositive());
                    return new ResponseEntity<>(validateService.save(existingValidate), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValidate(@PathVariable Long id) {
        if (validateService.findById(id).isPresent()) {
            validateService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
