$name = $args[0]

for($i = 1; $i -le 4; $i++)
{
    Get-Content .\test\$name\input$i.txt | java -cp .\bin\ $name | Out-File -Encoding utf8 .\test\$name\myout$i.txt
}