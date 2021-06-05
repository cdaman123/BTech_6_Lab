import mysql.connector
#try:
connection = mysql.connector.connect(host='localhost',
                                         database='sys',
                                         user='root',
                                         password='1234')

q = '''create table itemmast
    (
        ITNO decimal(4),
        NAME varchar(20),
        QOH decimal(5),
        CLASS char(1),
        UOM char(4),
        ROL decimal(5),
        ROQ decimal(5),
        RATE decimal(8,2)
        );
        '''
r = '''
        create table ittran(
            itno decimal(4) references itemmast(itno),
            trantype char(1) check (trantype in ('I','R')),
            trandate date,
            qty decimal(5)
        );

'''
if connection.is_connected():
    cursor = connection.cursor()
    cursor.execute(r)
    print(*cursor.fetchall(),sep = '\n')

##except:
#    print("Error")