# studentservice
学生管理系统
echo "# studentservice" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/winnie-0309/studentservice.git
git push -u origin master
git remote add origin https://github.com/winnie-0309/studentservice.git
git push -u origin master
…or import code from another repository
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.
一个简单的学生管理系统，主要从两个身份来说——老师和学生，对于老师来说，带验证码的登录注册，对学生进行增删改查，以分页的形式展示学生的所有信息；对于学生来说，带验证码的登录注册，以及查询自己的信息，修改自己的信息，以及查询其他学生的信息除密码以外。具体要求如下：
1、实现数据库连接，数据库有两个表，一个教师表，一个学生表教师表只有简单的username和password两个属性，学生表有sid name password gender birthday address等属性；
2、学生信息的增删改查；
3、写出老师及学生的登录注册的代码；
4、用代码生成一张验证码；
5、对学生信息进行分页
6、在网页上具体操作，并显示结果
