package com.codefarm.codefarmer.entity;

import com.codefarm.codefarmer.domain.NoticeDTO;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_NOTICE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends Period{
    @Id @GeneratedValue
    private Long noticeId;
    @NotNull
    private String noticeTitle;
    @NotNull
    private String noticeContent;
    @ColumnDefault("0")
    private int noticeViewCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notice")
    private List<NoticeFile> noticeFiles;

    public void update(NoticeDTO noticeDTO){
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }

    @Builder
    public Notice(String noticeTitle, String noticeContent, int noticeViewCount) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeViewCount = noticeViewCount;
    }
}
