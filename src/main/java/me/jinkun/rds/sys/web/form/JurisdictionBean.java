package me.jinkun.rds.sys.web.form;

import java.util.List;

public class JurisdictionBean {

    /**
     * roleId : 14
     * sels : [{"children":[{"_parentId":247,"children":[{"_parentId":248,"createTime":"2017-01-10 21:21:00","delFlag":0,"description":"","hasJurisdiction":true,"icon":"/resources/images/32x32/1-1.png","id":249,"isLeaf":0,"name":"用户管理","openMode":"0","page":1,"resourceType":0,"rows":10,"seq":0,"state":"open","status":0,"updateTime":"2017-05-22 22:40:00","url":"/live/users/ui/list"}],"createTime":"2017-01-10 21:20:48","delFlag":0,"description":"","hasJurisdiction":true,"icon":"/resources/images/32x32/sign-out.png","id":248,"isLeaf":1,"name":"直播会员","openMode":"0","page":1,"resourceType":0,"rows":10,"seq":0,"state":"open","status":0,"updateTime":"2017-05-22 22:50:08","url":""}],"createTime":"2017-01-10 21:20:31","delFlag":0,"description":"","hasJurisdiction":true,"icon":"/resources/images/32x32/photography.png","id":247,"isLeaf":1,"name":"直播管理","openMode":"0","page":1,"resourceType":0,"rows":10,"seq":0,"state":"open","status":0,"updateTime":"2017-05-22 22:55:36","url":""}]
     */

    private int roleId;
    private List<SelsBean> sels;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<SelsBean> getSels() {
        return sels;
    }

    public void setSels(List<SelsBean> sels) {
        this.sels = sels;
    }

    public static class SelsBean {
        /**
         * children : [{"_parentId":247,"children":[{"_parentId":248,"createTime":"2017-01-10 21:21:00","delFlag":0,"description":"","hasJurisdiction":true,"icon":"/resources/images/32x32/1-1.png","id":249,"isLeaf":0,"name":"用户管理","openMode":"0","page":1,"resourceType":0,"rows":10,"seq":0,"state":"open","status":0,"updateTime":"2017-05-22 22:40:00","url":"/live/users/ui/list"}],"createTime":"2017-01-10 21:20:48","delFlag":0,"description":"","hasJurisdiction":true,"icon":"/resources/images/32x32/sign-out.png","id":248,"isLeaf":1,"name":"直播会员","openMode":"0","page":1,"resourceType":0,"rows":10,"seq":0,"state":"open","status":0,"updateTime":"2017-05-22 22:50:08","url":""}]
         * createTime : 2017-01-10 21:20:31
         * delFlag : 0
         * description :
         * hasJurisdiction : true
         * icon : /resources/images/32x32/photography.png
         * id : 247
         * isLeaf : 1
         * name : 直播管理
         * openMode : 0
         * page : 1
         * resourceType : 0
         * rows : 10
         * seq : 0
         * state : open
         * status : 0
         * updateTime : 2017-05-22 22:55:36
         * url :
         */

        private String createTime;
        private int delFlag;
        private String description;
        private boolean hasJurisdiction;
        private String icon;
        private int id;
        private int isLeaf;
        private String name;
        private String openMode;
        private int page;
        private int resourceType;
        private int rows;
        private int seq;
        private String state;
        private int status;
        private String updateTime;
        private String url;
        private List<ChildrenBeanX> children;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isHasJurisdiction() {
            return hasJurisdiction;
        }

        public void setHasJurisdiction(boolean hasJurisdiction) {
            this.hasJurisdiction = hasJurisdiction;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsLeaf() {
            return isLeaf;
        }

        public void setIsLeaf(int isLeaf) {
            this.isLeaf = isLeaf;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpenMode() {
            return openMode;
        }

        public void setOpenMode(String openMode) {
            this.openMode = openMode;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {
            /**
             * _parentId : 247
             * children : [{"_parentId":248,"createTime":"2017-01-10 21:21:00","delFlag":0,"description":"","hasJurisdiction":true,"icon":"/resources/images/32x32/1-1.png","id":249,"isLeaf":0,"name":"用户管理","openMode":"0","page":1,"resourceType":0,"rows":10,"seq":0,"state":"open","status":0,"updateTime":"2017-05-22 22:40:00","url":"/live/users/ui/list"}]
             * createTime : 2017-01-10 21:20:48
             * delFlag : 0
             * description :
             * hasJurisdiction : true
             * icon : /resources/images/32x32/sign-out.png
             * id : 248
             * isLeaf : 1
             * name : 直播会员
             * openMode : 0
             * page : 1
             * resourceType : 0
             * rows : 10
             * seq : 0
             * state : open
             * status : 0
             * updateTime : 2017-05-22 22:50:08
             * url :
             */

            private int _parentId;
            private String createTime;
            private int delFlag;
            private String description;
            private boolean hasJurisdiction;
            private String icon;
            private int id;
            private int isLeaf;
            private String name;
            private String openMode;
            private int page;
            private int resourceType;
            private int rows;
            private int seq;
            private String state;
            private int status;
            private String updateTime;
            private String url;
            private List<ChildrenBean> children;

            public int get_parentId() {
                return _parentId;
            }

            public void set_parentId(int _parentId) {
                this._parentId = _parentId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isHasJurisdiction() {
                return hasJurisdiction;
            }

            public void setHasJurisdiction(boolean hasJurisdiction) {
                this.hasJurisdiction = hasJurisdiction;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsLeaf() {
                return isLeaf;
            }

            public void setIsLeaf(int isLeaf) {
                this.isLeaf = isLeaf;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOpenMode() {
                return openMode;
            }

            public void setOpenMode(String openMode) {
                this.openMode = openMode;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getResourceType() {
                return resourceType;
            }

            public void setResourceType(int resourceType) {
                this.resourceType = resourceType;
            }

            public int getRows() {
                return rows;
            }

            public void setRows(int rows) {
                this.rows = rows;
            }

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * _parentId : 248
                 * createTime : 2017-01-10 21:21:00
                 * delFlag : 0
                 * description :
                 * hasJurisdiction : true
                 * icon : /resources/images/32x32/1-1.png
                 * id : 249
                 * isLeaf : 0
                 * name : 用户管理
                 * openMode : 0
                 * page : 1
                 * resourceType : 0
                 * rows : 10
                 * seq : 0
                 * state : open
                 * status : 0
                 * updateTime : 2017-05-22 22:40:00
                 * url : /live/users/ui/list
                 */

                private int _parentId;
                private String createTime;
                private int delFlag;
                private String description;
                private boolean hasJurisdiction;
                private String icon;
                private int id;
                private int isLeaf;
                private String name;
                private String openMode;
                private int page;
                private int resourceType;
                private int rows;
                private int seq;
                private String state;
                private int status;
                private String updateTime;
                private String url;

                public int get_parentId() {
                    return _parentId;
                }

                public void set_parentId(int _parentId) {
                    this._parentId = _parentId;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public int getDelFlag() {
                    return delFlag;
                }

                public void setDelFlag(int delFlag) {
                    this.delFlag = delFlag;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public boolean isHasJurisdiction() {
                    return hasJurisdiction;
                }

                public void setHasJurisdiction(boolean hasJurisdiction) {
                    this.hasJurisdiction = hasJurisdiction;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getIsLeaf() {
                    return isLeaf;
                }

                public void setIsLeaf(int isLeaf) {
                    this.isLeaf = isLeaf;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getOpenMode() {
                    return openMode;
                }

                public void setOpenMode(String openMode) {
                    this.openMode = openMode;
                }

                public int getPage() {
                    return page;
                }

                public void setPage(int page) {
                    this.page = page;
                }

                public int getResourceType() {
                    return resourceType;
                }

                public void setResourceType(int resourceType) {
                    this.resourceType = resourceType;
                }

                public int getRows() {
                    return rows;
                }

                public void setRows(int rows) {
                    this.rows = rows;
                }

                public int getSeq() {
                    return seq;
                }

                public void setSeq(int seq) {
                    this.seq = seq;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
