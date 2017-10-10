package cn.mycloudedu.controller;

import cn.mycloudedu.framework.core.config.ServiceConfig;
import cn.mycloudedu.framework.core.exception.BusinessErrorCode;
import cn.mycloudedu.framework.core.exception.BusinessException;
import cn.mycloudedu.framework.core.exception.SystemErrorCode;
import cn.mycloudedu.framework.core.result.TotalResult;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @author: e诺
 * @Date: 2017/3/24
 */
public abstract class BaseController {
    private static final Logger log = Logger.getLogger(BaseController.class);

    @Autowired
    private ServiceConfig serviceConfig;

    /**
     * 业务性异常处理
     *
     * @param ex       异常
     * @param request  请求
     * @param response 返回
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleBusinessException(BusinessException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getCode() + ":" + ex.getMessage());
        TotalResult totalResult = new TotalResult();
        totalResult.setMessage(ex.getMessage());
        totalResult.setCode(ex.getCode());
        totalResult.setData(ex.getData());
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleUnauthorizedException(UnauthorizedException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.USER_NOTPRIVILEGE_ERROR()).getMessage() + exceptionStr);
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.USER_NOTPRIVILEGE_ERROR()).getCode());
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    /**
     * 数据库异常处理
     *
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleDataAccessException(DataAccessException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.DATABASE_ERROE()).getCode());
        totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.DATABASE_ERROE()).getMessage() + exceptionStr);
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    /**
     * 缺少参数
     *
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        TotalResult totalResult = new TotalResult();
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.PARAMETER_NOT_PRESENT()).getCode());
        totalResult.setMessage(ex.getParameterName() + ":" + SystemErrorCode.apply(SystemErrorCode.PARAMETER_NOT_PRESENT()).getMessage());
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleTypeMisMatchException(TypeMismatchException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.PARAMETER_NOT_PRESENT()).getMessage() + exceptionStr);
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.PARAMETER_NOT_PRESENT()).getCode());
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.PARAMETER_NOT_PRESENT()).getCode());
        totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.PARAMETER_NOT_PRESENT()).getMessage() + exceptionStr);
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    /**
     * 空指针异常处理
     *
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleBusinessException(NullPointerException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.NULLPOINTER_ERROR()).getCode());
        totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.NULLPOINTER_ERROR()).getMessage() + exceptionStr);
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    /**
     * 数组越界异常
     *
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleBusinessException(ArrayIndexOutOfBoundsException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        TotalResult totalResult = new TotalResult();
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.ARRAY_INDEXOUTOF_ERROR()).getCode());
        totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.ARRAY_INDEXOUTOF_ERROR()).getMessage());
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }


    /**
     * 系统异常
     *
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(IllegalArgumentException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        totalResult.setMessage(BusinessErrorCode.apply(BusinessErrorCode.PARAM_ERROR()).getMessage() + exceptionStr);
        totalResult.setCode(BusinessErrorCode.apply(BusinessErrorCode.PARAM_ERROR()).getCode());
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    /**
     * 系统运行时异常
     *
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(RuntimeException ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);

        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            totalResult.setMessage(ex.getMessage());
            totalResult.setCode(be.getCode());
            totalResult.setData(be.getData());
        } else {
            totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.RUNTIME_ERROR()).getMessage() + exceptionStr);
            totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.RUNTIME_ERROR()).getCode());
        }
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }

    /**
     * 系统异常
     *
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(), ex);
        Boolean isDebug = serviceConfig.getDebug();
        String exceptionStr = "";
        if (isDebug) {
            exceptionStr = ":" + ex.toString();
        }
        TotalResult totalResult = new TotalResult();
        totalResult.setMessage(SystemErrorCode.apply(SystemErrorCode.SYSTME_ERROR()).getMessage() + exceptionStr);
        totalResult.setCode(SystemErrorCode.apply(SystemErrorCode.SYSTME_ERROR()).getCode());
        if (callback != null) {
            return new JSONPObject(callback, totalResult);
        }
        return totalResult;
    }
}
