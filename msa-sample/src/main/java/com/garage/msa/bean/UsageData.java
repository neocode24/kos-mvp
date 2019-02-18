package com.garage.msa.bean;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RedisHash("usagedata")
public class UsageData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String key;

	private String value;

    private LocalDateTime refreshTime;

    @Builder
    public UsageData(
    		String key,
    		String value) {
        this.key = key;
        this.value = value;
        this.refreshTime = LocalDateTime.now();
    }

    public void refresh(String value, LocalDateTime refreshTime) {
        if(refreshTime.isAfter(this.refreshTime)){ // 저장된 데이터보다 최신 데이터일 경우
            this.value = value;
            this.refreshTime = refreshTime;
        }
    }
}
