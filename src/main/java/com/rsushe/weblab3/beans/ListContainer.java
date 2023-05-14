package com.rsushe.weblab3.beans;

import com.rsushe.weblab3.Service;
import com.rsushe.weblab3.dto.DotDto;
import lombok.Getter;
import lombok.Setter;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class ListContainer {
    @ManagedProperty(value = "#{service}")
    private Service service;
    private final String sessionId;
    private final List<DotDto> dotsList;

    public ListContainer() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        this.sessionId = session.getId();
        this.dotsList = new LinkedList<>();
    }

    public void removeUserDots() {
        System.out.println(sessionId);
        service.removeDotsBySessionId(sessionId);
        dotsList.clear();
    }
}
