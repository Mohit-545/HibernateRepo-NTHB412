//PrgmrProjId.java (Composite id class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class PrgmrProjId implements Serializable {
	private Integer prgmrId;
	private Integer projId;

}
