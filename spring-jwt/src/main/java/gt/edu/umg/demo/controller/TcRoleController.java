package gt.edu.umg.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.demo.model.TcRole;
import gt.edu.umg.demo.repository.TcRoleRepository;
import gt.edu.umg.demo.utils.ApiResponse;
import gt.edu.umg.demo.utils.AppProperty;
import gt.edu.umg.demo.utils.ResponseResult;

@RestController
@RequestMapping("/role")
public class TcRoleController {

    private boolean showErrors;

    @Autowired
    TcRoleRepository tcRoleRepository;

    ApiResponse apiResponse = new ApiResponse();

    @Autowired
    public TcRoleController(AppProperty properties) {
        this.showErrors = (properties.getShowErrors() == 1);
    }

    @PostMapping("/add")
    public ApiResponse setRole(@Valid @RequestBody TcRole tcRole) {
        try {
            tcRoleRepository.save(tcRole);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

    @GetMapping("/all")
    public ApiResponse getAll() {
        try {
            List<?> list = tcRoleRepository.findAll();
            apiResponse.setData(list);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

    @GetMapping("/{roleId}")
    public ApiResponse findById(@PathVariable(value = "roleId") Long roleId) {
        try {
            Optional<TcRole> found = tcRoleRepository.findById(roleId);
            List<TcRole> list = new ArrayList<>();
            list.add(found.get());
            apiResponse.setData(list);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

    @PutMapping("/{roleId}")
    public ApiResponse updateRole(@PathVariable(value = "roleId") Long roleId, @Valid @RequestBody TcRole tcRole) {
        try {
            Optional<TcRole> found = tcRoleRepository.findById(roleId);
            TcRole role = found.get();
            role.setRoleDesc(tcRole.getRoleDesc());
            role.setRoleCode(tcRole.getRoleCode());
            TcRole roleUpdated = tcRoleRepository.save(role);
            List<TcRole> list = new ArrayList<>();
            list.add(roleUpdated);
            apiResponse.setData(list);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

}
