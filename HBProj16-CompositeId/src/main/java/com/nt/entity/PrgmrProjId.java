//PrgmrProjId.java (Composite id class)
package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PrgmrProjId implements Serializable {
	private Integer prgmrId;
	private Integer projId;

}
