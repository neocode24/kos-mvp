package com.garage.manage.bean;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.garage.manage.remote.bean.Data_DataSvcDrctlyUseQntList;
import com.garage.manage.remote.bean.Data_UsePtrn3monsRetv;

import lombok.Builder;
import lombok.Getter;

@Getter
@RedisHash(value="usagedata", timeToLive=60)
public class UsageData {
	
	@Id
	private String key;
	
	private Data_UsePtrn3monsRetv usePtrn3monsRetv;
	
	private Data_DataSvcDrctlyUseQntList dataSvcDrctlyUseQntList;
	
    private LocalDateTime refreshTime;

    
    @Builder
    public UsageData(
    		String key, 
    		Data_UsePtrn3monsRetv usePtrn3monsRetv, 
    		Data_DataSvcDrctlyUseQntList dataSvcDrctlyUseQntList, 
    		LocalDateTime refreshTime) {
        this.key = key;
        this.usePtrn3monsRetv = usePtrn3monsRetv;
        this.refreshTime = refreshTime;
    }

    public void refresh(Data_UsePtrn3monsRetv usePtrn3monsRetv, LocalDateTime refreshTime){
        if(refreshTime.isAfter(this.refreshTime)){ // 저장된 데이터보다 최신 데이터일 경우
        	this.usePtrn3monsRetv = usePtrn3monsRetv;
            this.refreshTime = refreshTime;
        }
    }
    
    public void refresh(Data_DataSvcDrctlyUseQntList dataSvcDrctlyUseQntList, LocalDateTime refreshTime){
        if(refreshTime.isAfter(this.refreshTime)){ // 저장된 데이터보다 최신 데이터일 경우
        	this.dataSvcDrctlyUseQntList = dataSvcDrctlyUseQntList;
            this.refreshTime = refreshTime;
        }
    } 
    
}
