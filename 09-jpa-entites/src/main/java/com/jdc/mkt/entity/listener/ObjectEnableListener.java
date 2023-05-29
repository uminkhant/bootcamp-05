package com.jdc.mkt.entity.listener;

import java.io.Serializable;

public interface ObjectEnableListener extends Serializable {

	public void setTimes(Times times);

	public Times getTimes();

}
